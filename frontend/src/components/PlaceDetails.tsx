import { Alert, Card, CardContent, Chip, Divider, Typography } from '@mui/material'
import type { MapItem } from '../types'

type Props = { item: MapItem | null }

export function PlaceDetails({ item }: Props) {
  return (
    <Card>
      <CardContent>
        <Typography variant="overline" color="text.secondary">Selected place</Typography>
        <Typography variant="h6" sx={{ mb: 1 }}>{item?.title ?? 'Choose a marker'}</Typography>
        {item ? (
          <>
            <Chip
              size="small"
              label={item.categoryName}
              sx={{ bgcolor: `${item.categoryColor}22`, color: item.categoryColor, fontWeight: 600, mb: 2 }}
            />
            {item.description && (
              <Typography variant="body2" color="text.secondary">{item.description}</Typography>
            )}
            <Divider sx={{ my: 2 }} />
            <Typography variant="caption" color="text.secondary" sx={{ display: 'block' }}>Location</Typography>
            <Typography variant="body2" sx={{ fontWeight: 600 }}>{item.location}</Typography>
          </>
        ) : (
          <Alert severity="info">Select a marker on the map to inspect this place.</Alert>
        )}
      </CardContent>
    </Card>
  )
}
