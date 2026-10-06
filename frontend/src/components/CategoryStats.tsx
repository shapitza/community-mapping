import { Box, Card, CardActionArea, Stack, Typography } from '@mui/material'
import type { Category, MapItem } from '../types'
import { DEFAULT_CATEGORY_COLOR } from '../theme'

type Props = {
  categories: Category[]
  items: MapItem[]
  /** Currently filtered category id, or null when showing everything. */
  selectedCategoryId: number | null
  onSelect: (categoryId: number | null) => void
}

/** One card per category with the number of places in it. Clicking a card toggles the filter. */
export function CategoryStats({ categories, items, selectedCategoryId, onSelect }: Props) {
  if (categories.length === 0) return null

  return (
    <Box
      sx={{
        display: 'grid',
        gridTemplateColumns: { xs: 'repeat(2, 1fr)', md: 'repeat(4, 1fr)' },
        gap: 1.5,
        mb: 3,
      }}
    >
      {categories.map(category => {
        const color = category.color ?? DEFAULT_CATEGORY_COLOR
        const count = items.filter(item => item.categoryId === category.id).length
        const selected = selectedCategoryId === category.id
        return (
          <Card key={category.id} sx={selected ? { borderColor: color } : undefined}>
            <CardActionArea
              aria-pressed={selected}
              onClick={() => onSelect(selected ? null : category.id)}
              sx={{ p: 2 }}
            >
              <Stack direction="row" spacing={1.5} sx={{ alignItems: 'center' }}>
                <Box sx={{ p: 1.1, borderRadius: 2.5, bgcolor: `${color}22`, display: 'flex' }}>
                  <Box sx={{ width: 16, height: 16, borderRadius: '50%', bgcolor: color }} />
                </Box>
                <Box sx={{ minWidth: 0 }}>
                  <Typography variant="h6" sx={{ lineHeight: 1.2 }}>{count}</Typography>
                  <Typography variant="caption" color="text.secondary" noWrap sx={{ display: 'block' }}>
                    {category.name}
                  </Typography>
                </Box>
              </Stack>
            </CardActionArea>
          </Card>
        )
      })}
    </Box>
  )
}
