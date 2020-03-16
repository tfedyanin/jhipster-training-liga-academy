import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { ISimpleMessageWithService, defaultValue } from 'app/shared/model/simple-message-with-service.model';

export const ACTION_TYPES = {
  FETCH_SIMPLEMESSAGEWITHSERVICE_LIST: 'simpleMessageWithService/FETCH_SIMPLEMESSAGEWITHSERVICE_LIST',
  FETCH_SIMPLEMESSAGEWITHSERVICE: 'simpleMessageWithService/FETCH_SIMPLEMESSAGEWITHSERVICE',
  CREATE_SIMPLEMESSAGEWITHSERVICE: 'simpleMessageWithService/CREATE_SIMPLEMESSAGEWITHSERVICE',
  UPDATE_SIMPLEMESSAGEWITHSERVICE: 'simpleMessageWithService/UPDATE_SIMPLEMESSAGEWITHSERVICE',
  DELETE_SIMPLEMESSAGEWITHSERVICE: 'simpleMessageWithService/DELETE_SIMPLEMESSAGEWITHSERVICE',
  RESET: 'simpleMessageWithService/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ISimpleMessageWithService>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false
};

export type SimpleMessageWithServiceState = Readonly<typeof initialState>;

// Reducer

export default (state: SimpleMessageWithServiceState = initialState, action): SimpleMessageWithServiceState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICE_LIST):
    case REQUEST(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICE):
    case REQUEST(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICE):
    case REQUEST(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICE_LIST):
    case FAILURE(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICE):
    case FAILURE(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICE):
    case FAILURE(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICE):
    case FAILURE(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICE):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICE_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICE):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICE):
    case SUCCESS(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICE):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICE):
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

const apiUrl = 'api/simple-message-with-services';

// Actions

export const getEntities: ICrudGetAllAction<ISimpleMessageWithService> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICE_LIST,
  payload: axios.get<ISimpleMessageWithService>(`${apiUrl}?cacheBuster=${new Date().getTime()}`)
});

export const getEntity: ICrudGetAction<ISimpleMessageWithService> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICE,
    payload: axios.get<ISimpleMessageWithService>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ISimpleMessageWithService> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICE,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<ISimpleMessageWithService> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICE,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<ISimpleMessageWithService> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICE,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
