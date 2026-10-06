import { Avatar, Box, IconButton, Stack, Typography } from '@mui/material'
import MenuRoundedIcon from '@mui/icons-material/MenuRounded'
import NotificationsNoneRoundedIcon from '@mui/icons-material/NotificationsNoneRounded'
import { BORDER_COLOR } from '../theme'

type Props = { onOpenMenu: () => void }

/** Page header. The user and organization shown are placeholders until sign-in exists. */
export function TopBar({ onOpenMenu }: Props) {
  return (
    <Box
      component="header"
      sx={{
        height: 72,
        px: { xs: 2, md: 4 },
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'space-between',
        borderBottom: `1px solid ${BORDER_COLOR}`,
        bgcolor: 'rgba(245,247,242,.9)',
      }}
    >
      <Stack direction="row" spacing={1} sx={{ alignItems: 'center' }}>
        <IconButton aria-label="Open menu" onClick={onOpenMenu} sx={{ display: { lg: 'none' } }}>
          <MenuRoundedIcon />
        </IconButton>
        <Box>
          <Typography variant="caption" color="text.secondary">Greenfield Collective / Maps</Typography>
          <Typography variant="h6">Neighborhood atlas</Typography>
        </Box>
      </Stack>
      <Stack direction="row" spacing={1} sx={{ alignItems: 'center' }}>
        <IconButton aria-label="Notifications">
          <NotificationsNoneRoundedIcon />
        </IconButton>
        <Avatar sx={{ width: 34, height: 34, bgcolor: '#f8e8c6', color: '#8c621e', fontSize: 13, fontWeight: 800 }}>
          AM
        </Avatar>
        <Typography variant="body2" sx={{ display: { xs: 'none', sm: 'block' } }}>Ana</Typography>
      </Stack>
    </Box>
  )
}
