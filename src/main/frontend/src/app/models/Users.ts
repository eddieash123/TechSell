import { UserRole } from "./UserRole";

export interface Users {
    id:number,
    name: string,
    email:string,
    password:string,
    userRole:UserRole,
    locked:false,
    enabled:true
}