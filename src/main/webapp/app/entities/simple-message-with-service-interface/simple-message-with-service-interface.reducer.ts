import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { ISimpleMessageWithServiceInterface, defaultValue } from 'app/shared/model/simple-message-with-service-interface.model';

export const ACTION_TYPES = {
  FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACE_LIST: 'simpleMessageWithServiceInterface/FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACE_LIST',
  FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACE: 'simpleMessageWithServiceInterface/FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACE',
  CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACE: 'simpleMessageWithServiceInterface/CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACE',
  UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACE: 'simpleMessageWithServiceInterface/UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACE',
  DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACE: 'simpleMessageWithServiceInterface/DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACE',
  RESET: 'simpleMessageWithServiceInterface/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ISimpleMessageWithServiceInterface>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false
};

export type SimpleMessageWithServiceInterfaceState = Readonly<typeof initialState>;

// Reducer

export default (state: SimpleMessageWithServiceInterfaceState = initialState, action): SimpleMessageWithServiceInterfaceState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACE_LIST):
    case REQUEST(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACE):
    case REQUEST(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACE):
    case REQUEST(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACE_LIST):
    case FAILURE(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACE):
    case FAILURE(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACE):
    case FAILURE(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACE):
    case FAILURE(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACE):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACE_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACE):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACE):
    case SUCCESS(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACE):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACE):
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

const apiUrl = 'api/simple-message-with-service-interfaces';

// Actions

export const getEntities: ICrudGetAllAction<ISimpleMessageWithServiceInterface> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACE_LIST,
  payload: axios.get<ISimpleMessageWithServiceInterface>(`${apiUrl}?cacheBuster=${new Date().getTime()}`)
});

export const getEntity: ICrudGetAction<ISimpleMessageWithServiceInterface> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACE,
    payload: axios.get<ISimpleMessageWithServiceInterface>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ISimpleMessageWithServiceInterface> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACE,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<ISimpleMessageWithServiceInterface> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACE,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<ISimpleMessageWithServiceInterface> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACE,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
