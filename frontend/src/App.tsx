import { useMemo, useState } from 'react'
import { useMutation, useQuery, useQueryClient } from '@tanstack/react-query'
import { Alert, Box, Button, Drawer, Stack, Typography } from '@mui/material'
import AddRoundedIcon from '@mui/icons-material/AddRounded'
import LocationOnRoundedIcon from '@mui/icons-material/LocationOnRounded'
import { createMapItem, fetchCategories, fetchMapItems } from './api'
import { DEFAULT_CATEGORY_COLOR } from './theme'
import type { CreateMapItemRequest, MapItem } from './types'
import { AddPlaceDialog } from './components/AddPlaceDialog'
import { CategoryStats } from './components/CategoryStats'
import { MapHealthPanel, RecentActivityPanel } from './components/DemoPanels'
import { MapFilters } from './components/MapFilters'
import { MapView } from './components/MapView'
import { PlaceDetails } from './components/PlaceDetails'
import { Sidebar } from './components/Sidebar'
import { TopBar } from './components/TopBar'

// Placeholders until sign-in exists: the map centre will come from the
// organization's address and the acting user from the session.
const MAP_CENTER: [number, number] = [45.255, 19.84]
const MAP_ZOOM = 14
const DEMO_USER_ID = 1

function App() {
  const queryClient = useQueryClient()
  const itemsQuery = useQuery({ queryKey: ['map-items'], queryFn: fetchMapItems })
  const categoriesQuery = useQuery({ queryKey: ['categories'], queryFn: fetchCategories })

  const [query, setQuery] = useState('')
  const [categoryId, setCategoryId] = useState<number | null>(null)
  const [selectedId, setSelectedId] = useState<number | null>(null)
  const [menuOpen, setMenuOpen] = useState(false)
  const [addOpen, setAddOpen] = useState(false)

  const categories = categoriesQuery.data ?? []

  const items = useMemo<MapItem[]>(() => {
    const byId = new Map((categoriesQuery.data ?? []).map(category => [category.id, category]))
    return (itemsQuery.data ?? []).map(item => {
      const category = byId.get(item.categoryId)
      return {
        ...item,
        categoryName: category?.name ?? 'Uncategorized',
        categoryColor: category?.color ?? DEFAULT_CATEGORY_COLOR,
        location: item.address || `${item.latitude}, ${item.longitude}`,
      }
    })
  }, [itemsQuery.data, categoriesQuery.data])

  const visibleItems = useMemo(() => {
    const needle = query.trim().toLowerCase()
    return items.filter(item => {
      if (categoryId !== null && item.categoryId !== categoryId) return false
      if (!needle) return true
      return `${item.title} ${item.location} ${item.description ?? ''}`.toLowerCase().includes(needle)
    })
  }, [items, query, categoryId])

  const selected = items.find(item => item.id === selectedId) ?? null

  const addPlace = useMutation({
    mutationFn: (place: CreateMapItemRequest) => createMapItem({ ...place, actorUserId: DEMO_USER_ID }),
    onSuccess: async created => {
      await queryClient.invalidateQueries({ queryKey: ['map-items'] })
      setSelectedId(created.id)
      setAddOpen(false)
    },
  })

  const openAddDialog = () => {
    addPlace.reset()
    setAddOpen(true)
  }

  const loadFailed = itemsQuery.isError || categoriesQuery.isError

  return (
    <Box sx={{ minHeight: '100vh', display: 'flex', bgcolor: 'background.default' }}>
      <Box sx={{ display: { xs: 'none', lg: 'block' }, flexShrink: 0 }}>
        <Sidebar />
      </Box>
      <Drawer open={menuOpen} onClose={() => setMenuOpen(false)}>
        <Sidebar />
      </Drawer>

      <Box component="main" sx={{ flex: 1, minWidth: 0 }}>
        <TopBar onOpenMenu={() => setMenuOpen(true)} />

        <Box sx={{ p: { xs: 2, md: 4 } }}>
          {loadFailed && (
            <Alert severity="error" sx={{ mb: 2 }}>
              Could not reach the server. Check that the API is running and try again.
            </Alert>
          )}

          <Stack
            direction={{ xs: 'column', md: 'row' }}
            spacing={2}
            sx={{ justifyContent: 'space-between', alignItems: { xs: 'flex-start', md: 'flex-end' }, mb: 3 }}
          >
            <Box>
              <Stack direction="row" spacing={0.7} sx={{ alignItems: 'center', color: 'text.secondary', mb: 1 }}>
                <LocationOnRoundedIcon color="primary" fontSize="small" />
                <Typography variant="body2">Greenfield, Novi Sad</Typography>
              </Stack>
              <Typography variant="h4" component="h1" sx={{ fontSize: { xs: 32, md: 42 } }}>
                See what&apos;s happening
                <br />
                in your community.
              </Typography>
            </Box>
            <Button
              variant="contained"
              startIcon={<AddRoundedIcon />}
              disabled={categories.length === 0}
              onClick={openAddDialog}
            >
              Add to map
            </Button>
          </Stack>

          <CategoryStats
            categories={categories}
            items={items}
            selectedCategoryId={categoryId}
            onSelect={setCategoryId}
          />

          <MapFilters
            query={query}
            onQueryChange={setQuery}
            categories={categories}
            selectedCategoryId={categoryId}
            onCategoryChange={setCategoryId}
          />

          <Box sx={{ display: 'grid', gridTemplateColumns: { xs: '1fr', xl: 'minmax(0, 1fr) 320px' }, gap: 2 }}>
            <MapView center={MAP_CENTER} zoom={MAP_ZOOM} items={visibleItems} onSelect={item => setSelectedId(item.id)} />
            <PlaceDetails item={selected} />
          </Box>

          <Box sx={{ display: 'grid', gridTemplateColumns: { xs: '1fr', lg: '1.2fr 1fr' }, gap: 2, mt: 2 }}>
            <RecentActivityPanel />
            <MapHealthPanel />
          </Box>
        </Box>
      </Box>

      <AddPlaceDialog
        open={addOpen}
        categories={categories}
        defaultPosition={MAP_CENTER}
        saving={addPlace.isPending}
        failed={addPlace.isError}
        onClose={() => setAddOpen(false)}
        onSave={place => addPlace.mutate(place)}
      />
    </Box>
  )
}

export default App
