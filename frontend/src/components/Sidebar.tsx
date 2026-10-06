import { Avatar, Badge, Box, Button, Card, List, ListItemButton, ListItemText, Stack, Typography } from '@mui/material'
import AutoAwesomeRoundedIcon from '@mui/icons-material/AutoAwesomeRounded'
import LayersRoundedIcon from '@mui/icons-material/LayersRounded'
import { BORDER_COLOR } from '../theme'

const MAIN_LINKS = ['Overview', 'Map workspace', 'Activity', 'Members']
const WORKSPACE_LINKS = ['Categories & fields', 'Permissions']
const ACTIVE_LINK = 'Map workspace'

/**
 * Navigation column. The links are not wired to routes yet, and the
 * organization name is a placeholder until sign-in exists.
 */
export function Sidebar() {
  return (
    <Box
      component="aside"
      sx={{
        width: 250,
        height: '100%',
        p: 2.5,
        borderRight: `1px solid ${BORDER_COLOR}`,
        bgcolor: '#eef4ee',
        display: 'flex',
        flexDirection: 'column',
        gap: 2.5,
      }}
    >
      <Stack direction="row" spacing={1.2} sx={{ alignItems: 'center', px: 1 }}>
        <Box sx={{ bgcolor: 'primary.main', color: 'white', borderRadius: 3, p: 0.8, display: 'flex' }}>
          <LayersRoundedIcon />
        </Box>
        <Typography sx={{ fontWeight: 800 }}>Common Ground</Typography>
      </Stack>

      <Card sx={{ p: 1.5 }}>
        <Stack direction="row" spacing={1.2} sx={{ alignItems: 'center' }}>
          <Avatar sx={{ bgcolor: '#dff2e9', color: 'primary.main' }}>GC</Avatar>
          <Box>
            <Typography variant="body2" sx={{ fontWeight: 700 }}>Greenfield Collective</Typography>
            <Typography variant="caption" color="text.secondary">Community workspace</Typography>
          </Box>
        </Stack>
      </Card>

      <List disablePadding>
        {MAIN_LINKS.map(label => {
          const active = label === ACTIVE_LINK
          return (
            <ListItemButton key={label} selected={active} sx={{ borderRadius: 3, mb: 0.5 }}>
              <ListItemText
                primary={label}
                slotProps={{ primary: { sx: { fontSize: 14, fontWeight: active ? 700 : 500 } } }}
              />
              {label === 'Activity' && <Badge badgeContent={4} color="primary" sx={{ mr: 1.5 }} />}
            </ListItemButton>
          )
        })}
      </List>

      <Box>
        <Typography variant="overline" color="text.secondary" sx={{ px: 1 }}>Workspace</Typography>
        <List disablePadding>
          {WORKSPACE_LINKS.map(label => (
            <ListItemButton key={label} sx={{ borderRadius: 3 }}>
              <ListItemText primary={label} slotProps={{ primary: { sx: { fontSize: 14 } } }} />
            </ListItemButton>
          ))}
        </List>
      </Box>

      <Box sx={{ mt: 'auto', p: 2, borderRadius: 4, bgcolor: 'primary.main', color: 'white' }}>
        <AutoAwesomeRoundedIcon />
        <Typography sx={{ fontWeight: 700, mt: 2 }}>Make your place visible.</Typography>
        <Typography variant="caption" sx={{ opacity: 0.78, display: 'block', mt: 0.5 }}>
          Invite neighbors to add observations and keep your map alive.
        </Typography>
        <Button
          fullWidth
          variant="contained"
          sx={{ mt: 2, bgcolor: 'white', color: 'primary.main', '&:hover': { bgcolor: '#f2faf5' } }}
        >
          Invite members
        </Button>
      </Box>
    </Box>
  )
}
