export type Category = {
  id: number
  mapId: number
  name: string
  description?: string
  color?: string
  icon?: string
  active: boolean
}

/** A map item exactly as the API returns it. */
export type RawMapItem = {
  id: number
  mapId: number
  categoryId: number
  statusId?: number
  title: string
  description?: string
  latitude: number
  longitude: number
  address?: string
  updatedAt?: string
}

/** A map item joined with its category, ready for display. */
export type MapItem = RawMapItem & {
  categoryName: string
  categoryColor: string
  location: string
}

export type CreateMapItemRequest = {
  categoryId: number
  statusId?: number
  title: string
  description?: string
  latitude: number
  longitude: number
  address?: string
  actorUserId?: number
}
