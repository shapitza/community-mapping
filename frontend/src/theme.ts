import { createTheme } from '@mui/material'

export const BORDER_COLOR = '#e1e9e1'
/** Used for markers and chips when a category has no colour of its own. */
export const DEFAULT_CATEGORY_COLOR = '#1f755d'

export const theme = createTheme({
  palette: {
    mode: 'light',
    primary: { main: '#1f755d' },
    background: { default: '#f5f7f2', paper: '#ffffff' },
    text: { primary: '#183028', secondary: '#6d7d76' },
  },
  typography: {
    fontFamily: 'Inter, ui-sans-serif, system-ui, sans-serif',
    h4: { fontWeight: 700, letterSpacing: '-.04em' },
    h6: { fontWeight: 700 },
  },
  shape: { borderRadius: 16 },
  components: {
    MuiCard: {
      styleOverrides: {
        root: { border: `1px solid ${BORDER_COLOR}`, boxShadow: '0 8px 30px rgba(31,73,54,.05)' },
      },
    },
    MuiButton: {
      styleOverrides: { root: { textTransform: 'none', borderRadius: 12, fontWeight: 700 } },
    },
  },
})
