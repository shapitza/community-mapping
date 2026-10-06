import { MapContainer, Marker, Popup, TileLayer } from 'react-leaflet'
import L from 'leaflet'
import { Card } from '@mui/material'
import type { MapItem } from '../types'

type Props = {
  center: [number, number]
  zoom: number
  items: MapItem[]
  onSelect: (item: MapItem) => void
}

const MAP_HEIGHT = 540

function markerIcon(color: string) {
  return L.divIcon({
    className: 'custom-marker',
    html: `<span style="background:${color}"></span>`,
    iconSize: [28, 28],
    iconAnchor: [14, 14],
  })
}

export function MapView({ center, zoom, items, onSelect }: Props) {
  return (
    <Card sx={{ overflow: 'hidden', minHeight: MAP_HEIGHT }}>
      <MapContainer center={center} zoom={zoom} scrollWheelZoom style={{ height: MAP_HEIGHT, width: '100%' }}>
        <TileLayer
          attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />
        {items.map(item => (
          <Marker
            key={item.id}
            position={[item.latitude, item.longitude]}
            icon={markerIcon(item.categoryColor)}
            title={item.title}
            eventHandlers={{ click: () => onSelect(item) }}
          >
            <Popup>
              <strong>{item.title}</strong>
              <br />
              {item.location}
            </Popup>
          </Marker>
        ))}
      </MapContainer>
    </Card>
  )
}
