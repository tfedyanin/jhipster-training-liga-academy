import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import {
  ISimpleMessageWithServiceInterfaceDtoPagination,
  defaultValue
} from 'app/shared/model/simple-message-with-service-interface-dto-pagination.model';

export const ACTION_TYPES = {
  FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION_LIST:
    'simpleMessageWithServiceInterfaceDtoPagination/FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION_LIST',
  FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION:
    'simpleMessageWithServiceInterfaceDtoPagination/FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION',
  CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION:
    'simpleMessageWithServiceInterfaceDtoPagination/CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION',
  UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION:
    'simpleMessageWithServiceInterfaceDtoPagination/UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION',
  DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION:
    'simpleMessageWithServiceInterfaceDtoPagination/DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION',
  RESET: 'simpleMessageWithServiceInterfaceDtoPagination/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ISimpleMessageWithServiceInterfaceDtoPagination>,
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type SimpleMessageWithServiceInterfaceDtoPaginationState = Readonly<typeof initialState>;

// Reducer

export default (
  state: SimpleMessageWithServiceInterfaceDtoPaginationState = initialState,
  action
): SimpleMessageWithServiceInterfaceDtoPaginationState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION_LIST):
    case REQUEST(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION):
    case REQUEST(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION):
    case REQUEST(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION_LIST):
    case FAILURE(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION):
    case FAILURE(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION):
    case FAILURE(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION):
    case FAILURE(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data,
        totalItems: parseInt(action.payload.headers['x-total-count'], 10)
      };
    case SUCCESS(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION):
    case SUCCESS(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION):
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

const apiUrl = 'api/simple-message-with-service-interface-dto-paginations';

// Actions

export const getEntities: ICrudGetAllAction<ISimpleMessageWithServiceInterfaceDtoPagination> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION_LIST,
    payload: axios.get<ISimpleMessageWithServiceInterfaceDtoPagination>(
      `${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`
    )
  };
};

export const getEntity: ICrudGetAction<ISimpleMessageWithServiceInterfaceDtoPagination> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION,
    payload: axios.get<ISimpleMessageWithServiceInterfaceDtoPagination>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ISimpleMessageWithServiceInterfaceDtoPagination> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<ISimpleMessageWithServiceInterfaceDtoPagination> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<ISimpleMessageWithServiceInterfaceDtoPagination> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOPAGINATION,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
