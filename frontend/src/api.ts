import type { Category, CreateMapItemRequest, MapItem, RawMapItem } from './types'

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL ?? 'http://localhost:8080/api'
const MAP_ID = Number(import.meta.env.VITE_MAP_ID ?? 1)

async function request<T>(path: string, init?: RequestInit): Promise<T> {
  const response = await fetch(`${API_BASE_URL}${path}`, {
    ...init,
    headers: { 'Content-Type': 'application/json', ...(init?.headers ?? {}) },
  })
  if (!response.ok) throw new Error(`${response.status} ${response.statusText}`)
  if (response.status === 204) return undefined as T
  return response.json() as Promise<T>
}

export const fetchCategories = () => request<Category[]>(`/maps/${MAP_ID}/categories`)

export async function fetchMapItems(): Promise<MapItem[]> {
  const [items, categories] = await Promise.all([
    request<RawMapItem[]>(`/maps/${MAP_ID}/items`),
    fetchCategories(),
  ])
  const byId = new Map(categories.map(c => [c.id, c]))
  return items.map(item => ({
    ...item,
    category: byId.get(item.categoryId)?.name ?? 'Uncategorized',
    categoryColor: byId.get(item.categoryId)?.color,
    location: item.address || `${item.latitude}, ${item.longitude}`,
  }))
}

export const createMapItem = (payload: CreateMapItemRequest) => request<RawMapItem>(`/maps/${MAP_ID}/items`, {
  method: 'POST',
  body: JSON.stringify(payload),
})

export const checkHealth = () => request<{ status: string; application: string }>('/health')
