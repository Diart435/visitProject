export interface Service{
    id: number,
    title: string,
    type: number,
    cost: string
}
export interface ServiceList{
    data: Service[][];
}