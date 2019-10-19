import {useContext, createContext} from 'react'

export const PartyContext = createContext();
export const usePartyContext = () => useContext(PartyContext);

// export const PositionContext = createContext();
// export const usePositionContext = () => useContext(PositionContext);