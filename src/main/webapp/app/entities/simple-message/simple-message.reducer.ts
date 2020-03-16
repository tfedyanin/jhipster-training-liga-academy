import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { ISimpleMessage, defaultValue } from 'app/shared/model/simple-message.model';

export const ACTION_TYPES = {
  FETCH_SIMPLEMESSAGE_LIST: 'simpleMessage/FETCH_SIMPLEMESSAGE_LIST',
  FETCH_SIMPLEMESSAGE: 'simpleMessage/FETCH_SIMPLEMESSAGE',
  CREATE_SIMPLEMESSAGE: 'simpleMessage/CREATE_SIMPLEMESSAGE',
  UPDATE_SIMPLEMESSAGE: 'simpleMessage/UPDATE_SIMPLEMESSAGE',
  DELETE_SIMPLEMESSAGE: 'simpleMessage/DELETE_SIMPLEMESSAGE',
  RESET: 'simpleMessage/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ISimpleMessage>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false
};

export type SimpleMessageState = Readonly<typeof initialState>;

// Reducer

export default (state: SimpleMessageState = initialState, action): SimpleMessageState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_SIMPLEMESSAGE_LIST):
    case REQUEST(ACTION_TYPES.FETCH_SIMPLEMESSAGE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_SIMPLEMESSAGE):
    case REQUEST(ACTION_TYPES.UPDATE_SIMPLEMESSAGE):
    case REQUEST(ACTION_TYPES.DELETE_SIMPLEMESSAGE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_SIMPLEMESSAGE_LIST):
    case FAILURE(ACTION_TYPES.FETCH_SIMPLEMESSAGE):
    case FAILURE(ACTION_TYPES.CREATE_SIMPLEMESSAGE):
    case FAILURE(ACTION_TYPES.UPDATE_SIMPLEMESSAGE):
    case FAILURE(ACTION_TYPES.DELETE_SIMPLEMESSAGE):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_SIMPLEMESSAGE_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_SIMPLEMESSAGE):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_SIMPLEMESSAGE):
    case SUCCESS(ACTION_TYPES.UPDATE_SIMPLEMESSAGE):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_SIMPLEMESSAGE):
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

const apiUrl = 'api/simple-messages';

// Actions

export const getEntities: ICrudGetAllAction<ISimpleMessage> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_SIMPLEMESSAGE_LIST,
  payload: axios.get<ISimpleMessage>(`${apiUrl}?cacheBuster=${new Date().getTime()}`)
});

export const getEntity: ICrudGetAction<ISimpleMessage> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_SIMPLEMESSAGE,
    payload: axios.get<ISimpleMessage>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ISimpleMessage> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_SIMPLEMESSAGE,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<ISimpleMessage> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_SIMPLEMESSAGE,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<ISimpleMessage> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_SIMPLEMESSAGE,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
