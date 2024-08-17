import { apiClient } from "./ApiClient";

export const executeBasicAuthenticationService
    = (token) => apiClient.get(`/basicauth`,{
        headers: {
            Authorization: token
        }
    })
