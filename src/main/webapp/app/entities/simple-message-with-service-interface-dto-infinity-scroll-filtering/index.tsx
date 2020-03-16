import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering from './simple-message-with-service-interface-dto-infinity-scroll-filtering';
import SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDetail from './simple-message-with-service-interface-dto-infinity-scroll-filtering-detail';
import SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringUpdate from './simple-message-with-service-interface-dto-infinity-scroll-filtering-update';
import SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDeleteDialog from './simple-message-with-service-interface-dto-infinity-scroll-filtering-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute
        exact
        path={`${match.url}/:id/delete`}
        component={SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDeleteDialog}
      />
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringUpdate} />
      <ErrorBoundaryRoute
        exact
        path={`${match.url}/:id/edit`}
        component={SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringUpdate}
      />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={SimpleMessageWithServiceInterfaceDtoInfinityScrollFilteringDetail} />
      <ErrorBoundaryRoute path={match.url} component={SimpleMessageWithServiceInterfaceDtoInfinityScrollFiltering} />
    </Switch>
  </>
);

export default Routes;
