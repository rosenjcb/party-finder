import {useContext, createContext} from 'react'

export const PartyContext = createContext();
export const usePartyContext = () => useContext(PartyContext);