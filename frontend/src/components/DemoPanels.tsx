import { Avatar, Box, Card, CardContent, Stack, Typography } from '@mui/material'
import AnalyticsRoundedIcon from '@mui/icons-material/AnalyticsRounded'

/*
 * Static placeholder content from the original design. Both panels will be
 * replaced with real data once the activity log is exposed by the API.
 */

const SAMPLE_ACTIVITY = [
  { initials: 'JM', name: 'Jelena M.', action: 'added a new observation to', target: 'Riverside community garden', when: '12 minutes ago', bg: '#dff2e9', fg: '#1f755d' },
  { initials: 'NK', name: 'Nikola K.', action: 'verified', target: 'Community repair workshop', when: 'Yesterday at 16:10', bg: '#e0eef7', fg: '#397aa6' },
]

export function RecentActivityPanel() {
  return (
    <Card>
      <CardContent>
        <Typography variant="overline" color="text.secondary">Recent activity</Typography>
        <Typography variant="h6" sx={{ mb: 2 }}>Your community is moving</Typography>
        <Stack spacing={2}>
          {SAMPLE_ACTIVITY.map(entry => (
            <Stack key={entry.initials} direction="row" spacing={1.5}>
              <Avatar sx={{ bgcolor: entry.bg, color: entry.fg }}>{entry.initials}</Avatar>
              <Box>
                <Typography variant="body2">
                  <b>{entry.name}</b> {entry.action} <b>{entry.target}</b>
                </Typography>
                <Typography variant="caption" color="text.secondary">{entry.when}</Typography>
              </Box>
            </Stack>
          ))}
        </Stack>
      </CardContent>
    </Card>
  )
}

export function MapHealthPanel() {
  return (
    <Card sx={{ bgcolor: '#edf7f0' }}>
      <CardContent>
        <Stack direction="row" sx={{ justifyContent: 'space-between' }}>
          <Box>
            <Typography variant="overline" color="primary">Map health</Typography>
            <Typography variant="h6">A healthy shared picture</Typography>
          </Box>
          <AnalyticsRoundedIcon color="primary" />
        </Stack>
        <Typography sx={{ fontSize: 42, fontWeight: 800, mt: 2 }}>84%</Typography>
        <Typography variant="caption" color="text.secondary">of places have recent observations</Typography>
        <Box sx={{ mt: 2, height: 8, borderRadius: 8, bgcolor: '#cfe8d8' }}>
          <Box sx={{ width: '84%', height: '100%', bgcolor: 'primary.main', borderRadius: 8 }} />
        </Box>
      </CardContent>
    </Card>
  )
}
