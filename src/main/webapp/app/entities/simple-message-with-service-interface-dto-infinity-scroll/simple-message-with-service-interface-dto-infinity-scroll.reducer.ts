import axios from 'axios';
import {
  parseHeaderForLinks,
  loadMoreDataWhenScrolled,
  ICrudGetAction,
  ICrudGetAllAction,
  ICrudPutAction,
  ICrudDeleteAction
} from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import {
  ISimpleMessageWithServiceInterfaceDtoInfinityScroll,
  defaultValue
} from 'app/shared/model/simple-message-with-service-interface-dto-infinity-scroll.model';

export const ACTION_TYPES = {
  FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL_LIST:
    'simpleMessageWithServiceInterfaceDtoInfinityScroll/FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL_LIST',
  FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL:
    'simpleMessageWithServiceInterfaceDtoInfinityScroll/FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL',
  CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL:
    'simpleMessageWithServiceInterfaceDtoInfinityScroll/CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL',
  UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL:
    'simpleMessageWithServiceInterfaceDtoInfinityScroll/UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL',
  DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL:
    'simpleMessageWithServiceInterfaceDtoInfinityScroll/DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL',
  RESET: 'simpleMessageWithServiceInterfaceDtoInfinityScroll/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ISimpleMessageWithServiceInterfaceDtoInfinityScroll>,
  entity: defaultValue,
  links: { next: 0 },
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type SimpleMessageWithServiceInterfaceDtoInfinityScrollState = Readonly<typeof initialState>;

// Reducer

export default (
  state: SimpleMessageWithServiceInterfaceDtoInfinityScrollState = initialState,
  action
): SimpleMessageWithServiceInterfaceDtoInfinityScrollState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL_LIST):
    case REQUEST(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL):
    case REQUEST(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL):
    case REQUEST(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL_LIST):
    case FAILURE(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL):
    case FAILURE(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL):
    case FAILURE(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL):
    case FAILURE(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL_LIST): {
      const links = parseHeaderForLinks(action.payload.headers.link);

      return {
        ...state,
        loading: false,
        links,
        entities: loadMoreDataWhenScrolled(state.entities, action.payload.data, links),
        totalItems: parseInt(action.payload.headers['x-total-count'], 10)
      };
    }
    case SUCCESS(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL):
    case SUCCESS(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL):
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

const apiUrl = 'api/simple-message-with-service-interface-dto-infinity-scrolls';

// Actions

export const getEntities: ICrudGetAllAction<ISimpleMessageWithServiceInterfaceDtoInfinityScroll> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL_LIST,
    payload: axios.get<ISimpleMessageWithServiceInterfaceDtoInfinityScroll>(
      `${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`
    )
  };
};

export const getEntity: ICrudGetAction<ISimpleMessageWithServiceInterfaceDtoInfinityScroll> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL,
    payload: axios.get<ISimpleMessageWithServiceInterfaceDtoInfinityScroll>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ISimpleMessageWithServiceInterfaceDtoInfinityScroll> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  return result;
};

export const updateEntity: ICrudPutAction<ISimpleMessageWithServiceInterfaceDtoInfinityScroll> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  return result;
};

export const deleteEntity: ICrudDeleteAction<ISimpleMessageWithServiceInterfaceDtoInfinityScroll> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLL,
    payload: axios.delete(requestUrl)
  });
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
