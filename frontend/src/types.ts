export type Category = { id: number; mapId: number; name: string; description?: string; color?: string; icon?: string; active: boolean }
export type RawMapItem = { id: number; mapId: number; categoryId: number; statusId?: number; title: string; description?: string; latitude: number; longitude: number; address?: string; updatedAt?: string }
export type MapItem = RawMapItem & { category: string; categoryColor?: string; location: string }
export type CreateMapItemRequest = { categoryId: number; statusId?: number; title: string; description?: string; latitude: number; longitude: number; address?: string; actorUserId?: number }
