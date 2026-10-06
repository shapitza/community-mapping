import { InputAdornment, MenuItem, Select, Stack, TextField } from '@mui/material'
import FilterAltOutlinedIcon from '@mui/icons-material/FilterAltOutlined'
import SearchRoundedIcon from '@mui/icons-material/SearchRounded'
import type { Category } from '../types'

type Props = {
  query: string
  onQueryChange: (query: string) => void
  categories: Category[]
  selectedCategoryId: number | null
  onCategoryChange: (categoryId: number | null) => void
}

const ALL = 'all'

export function MapFilters({ query, onQueryChange, categories, selectedCategoryId, onCategoryChange }: Props) {
  return (
    <Stack direction={{ xs: 'column', sm: 'row' }} spacing={1.5} sx={{ mb: 2 }}>
      <TextField
        fullWidth
        size="small"
        value={query}
        onChange={event => onQueryChange(event.target.value)}
        placeholder="Search places, notes..."
        slotProps={{
          htmlInput: { 'aria-label': 'Search places' },
          input: {
            startAdornment: (
              <InputAdornment position="start">
                <SearchRoundedIcon sx={{ color: 'text.secondary' }} />
              </InputAdornment>
            ),
          },
        }}
      />
      <Select
        size="small"
        value={selectedCategoryId === null ? ALL : String(selectedCategoryId)}
        onChange={event => onCategoryChange(event.target.value === ALL ? null : Number(event.target.value))}
        startAdornment={<FilterAltOutlinedIcon sx={{ mr: 1, color: 'text.secondary' }} />}
        inputProps={{ 'aria-label': 'Filter by category' }}
        sx={{ minWidth: { sm: 210 } }}
      >
        <MenuItem value={ALL}>All categories</MenuItem>
        {categories.map(category => (
          <MenuItem key={category.id} value={String(category.id)}>{category.name}</MenuItem>
        ))}
      </Select>
    </Stack>
  )
}
