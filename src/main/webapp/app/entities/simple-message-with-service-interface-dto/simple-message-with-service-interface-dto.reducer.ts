import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { ISimpleMessageWithServiceInterfaceDto, defaultValue } from 'app/shared/model/simple-message-with-service-interface-dto.model';

export const ACTION_TYPES = {
  FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO_LIST: 'simpleMessageWithServiceInterfaceDto/FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO_LIST',
  FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO: 'simpleMessageWithServiceInterfaceDto/FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO',
  CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO: 'simpleMessageWithServiceInterfaceDto/CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO',
  UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO: 'simpleMessageWithServiceInterfaceDto/UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO',
  DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO: 'simpleMessageWithServiceInterfaceDto/DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO',
  RESET: 'simpleMessageWithServiceInterfaceDto/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ISimpleMessageWithServiceInterfaceDto>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false
};

export type SimpleMessageWithServiceInterfaceDtoState = Readonly<typeof initialState>;

// Reducer

export default (state: SimpleMessageWithServiceInterfaceDtoState = initialState, action): SimpleMessageWithServiceInterfaceDtoState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO_LIST):
    case REQUEST(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO):
    case REQUEST(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO):
    case REQUEST(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO_LIST):
    case FAILURE(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO):
    case FAILURE(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO):
    case FAILURE(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO):
    case FAILURE(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO):
    case SUCCESS(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: {}
      };
    case ACTION_TYPES.RESET:
      return {
        ...initialState
      };
    default:
      return state;
  }
};

const apiUrl = 'api/simple-message-with-service-interface-dtos';

// Actions

export const getEntities: ICrudGetAllAction<ISimpleMessageWithServiceInterfaceDto> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO_LIST,
  payload: axios.get<ISimpleMessageWithServiceInterfaceDto>(`${apiUrl}?cacheBuster=${new Date().getTime()}`)
});

export const getEntity: ICrudGetAction<ISimpleMessageWithServiceInterfaceDto> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO,
    payload: axios.get<ISimpleMessageWithServiceInterfaceDto>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ISimpleMessageWithServiceInterfaceDto> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<ISimpleMessageWithServiceInterfaceDto> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<ISimpleMessageWithServiceInterfaceDto> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTO,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
