import {useContext, createContext} from 'react'

export const PopupContext = createContext();
export const usePopupContext = () => useContext(PopupContext);
