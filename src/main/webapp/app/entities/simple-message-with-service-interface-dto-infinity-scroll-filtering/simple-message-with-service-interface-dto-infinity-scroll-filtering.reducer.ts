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
  ISimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering,
  defaultValue
} from 'app/shared/model/simple-message-with-service-interface-dto-infinity-scroll-filtering.model';

export const ACTION_TYPES = {
  FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING_LIST:
    'simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering/FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING_LIST',
  FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING:
    'simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering/FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING',
  CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING:
    'simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering/CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING',
  UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING:
    'simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering/UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING',
  DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING:
    'simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering/DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING',
  RESET: 'simpleMessageWithServiceInterfaceDtoInfinityScrollFiltering/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ISimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering>,
  entity: defaultValue,
  links: { next: 0 },
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringState = Readonly<typeof initialState>;

// Reducer

export default (
  state: SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringState = initialState,
  action
): SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING_LIST):
    case REQUEST(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING):
    case REQUEST(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING):
    case REQUEST(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING_LIST):
    case FAILURE(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING):
    case FAILURE(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING):
    case FAILURE(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING):
    case FAILURE(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING_LIST): {
      const links = parseHeaderForLinks(action.payload.headers.link);

      return {
        ...state,
        loading: false,
        links,
        entities: loadMoreDataWhenScrolled(state.entities, action.payload.data, links),
        totalItems: parseInt(action.payload.headers['x-total-count'], 10)
      };
    }
    case SUCCESS(ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING):
    case SUCCESS(ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING):
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

const apiUrl = 'api/simple-message-with-service-interface-dto-infinity-scroll-filterings';

// Actions

export const getEntities: ICrudGetAllAction<ISimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING_LIST,
    payload: axios.get<ISimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering>(
      `${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`
    )
  };
};

export const getEntity: ICrudGetAction<ISimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING,
    payload: axios.get<ISimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ISimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  return result;
};

export const updateEntity: ICrudPutAction<ISimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  return result;
};

export const deleteEntity: ICrudDeleteAction<ISimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_SIMPLEMESSAGEWITHSERVICEINTERFACEDTOINFINITYSCROLLFILTERING,
    payload: axios.delete(requestUrl)
  });
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
