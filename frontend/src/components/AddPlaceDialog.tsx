import { useEffect, useState } from 'react'
import {
  Alert, Button, Dialog, DialogActions, DialogContent, DialogTitle,
  FormControl, InputLabel, MenuItem, Select, Stack, TextField,
} from '@mui/material'
import type { Category, CreateMapItemRequest } from '../types'

type Props = {
  open: boolean
  categories: Category[]
  /** Coordinates the form starts from (the map centre). */
  defaultPosition: [number, number]
  saving: boolean
  failed: boolean
  onClose: () => void
  onSave: (place: CreateMapItemRequest) => void
}

type FormState = {
  title: string
  description: string
  categoryId: number | ''
  address: string
  latitude: string
  longitude: string
}

export function AddPlaceDialog({ open, categories, defaultPosition, saving, failed, onClose, onSave }: Props) {
  const [form, setForm] = useState<FormState>(() => emptyForm(categories, defaultPosition))

  // Start from a clean form every time the dialog opens.
  useEffect(() => {
    if (open) setForm(emptyForm(categories, defaultPosition))
  }, [open])

  const latitude = Number(form.latitude)
  const longitude = Number(form.longitude)
  const validPosition =
    form.latitude !== '' && form.longitude !== '' &&
    Number.isFinite(latitude) && Math.abs(latitude) <= 90 &&
    Number.isFinite(longitude) && Math.abs(longitude) <= 180
  const canSave = form.title.trim() !== '' && form.categoryId !== '' && validPosition && !saving

  const set = <K extends keyof FormState>(key: K, value: FormState[K]) =>
    setForm(current => ({ ...current, [key]: value }))

  const save = () => {
    if (!canSave || form.categoryId === '') return
    onSave({
      title: form.title.trim(),
      description: form.description.trim() || undefined,
      categoryId: form.categoryId,
      address: form.address.trim() || undefined,
      latitude,
      longitude,
    })
  }

  return (
    <Dialog open={open} onClose={onClose} fullWidth maxWidth="sm">
      <DialogTitle>Add place to map</DialogTitle>
      <DialogContent>
        <Stack spacing={2} sx={{ mt: 1 }}>
          <TextField label="Title" required autoFocus value={form.title} onChange={e => set('title', e.target.value)} />
          <TextField
            label="Description"
            multiline
            minRows={3}
            value={form.description}
            onChange={e => set('description', e.target.value)}
          />
          <FormControl required>
            <InputLabel id="add-place-category">Category</InputLabel>
            <Select
              labelId="add-place-category"
              label="Category"
              value={form.categoryId === '' ? '' : String(form.categoryId)}
              onChange={e => set('categoryId', Number(e.target.value))}
            >
              {categories.map(category => (
                <MenuItem key={category.id} value={String(category.id)}>{category.name}</MenuItem>
              ))}
            </Select>
          </FormControl>
          <TextField label="Location / address" value={form.address} onChange={e => set('address', e.target.value)} />
          <Stack direction="row" spacing={2}>
            <TextField
              fullWidth
              required
              type="number"
              label="Latitude"
              value={form.latitude}
              onChange={e => set('latitude', e.target.value)}
              slotProps={{ htmlInput: { step: 'any', min: -90, max: 90 } }}
            />
            <TextField
              fullWidth
              required
              type="number"
              label="Longitude"
              value={form.longitude}
              onChange={e => set('longitude', e.target.value)}
              slotProps={{ htmlInput: { step: 'any', min: -180, max: 180 } }}
            />
          </Stack>
          {failed && <Alert severity="error">Could not save the place.</Alert>}
        </Stack>
      </DialogContent>
      <DialogActions>
        <Button onClick={onClose}>Cancel</Button>
        <Button variant="contained" disabled={!canSave} onClick={save}>
          {saving ? 'Saving…' : 'Save'}
        </Button>
      </DialogActions>
    </Dialog>
  )
}

function emptyForm(categories: Category[], [latitude, longitude]: [number, number]): FormState {
  return {
    title: '',
    description: '',
    categoryId: categories[0]?.id ?? '',
    address: '',
    latitude: String(latitude),
    longitude: String(longitude),
  }
}
