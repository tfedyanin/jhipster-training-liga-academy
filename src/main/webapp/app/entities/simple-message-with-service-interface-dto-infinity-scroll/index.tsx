import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import SimpleMessageWithServiceInterfaceDtoInfinityScroll from './simple-message-with-service-interface-dto-infinity-scroll';
import SimpleMessageWithServiceInterfaceDtoInfinityScrollDetail from './simple-message-with-service-interface-dto-infinity-scroll-detail';
import SimpleMessageWithServiceInterfaceDtoInfinityScrollUpdate from './simple-message-with-service-interface-dto-infinity-scroll-update';
import SimpleMessageWithServiceInterfaceDtoInfinityScrollDeleteDialog from './simple-message-with-service-interface-dto-infinity-scroll-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute
        exact
        path={`${match.url}/:id/delete`}
        component={SimpleMessageWithServiceInterfaceDtoInfinityScrollDeleteDialog}
      />
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={SimpleMessageWithServiceInterfaceDtoInfinityScrollUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={SimpleMessageWithServiceInterfaceDtoInfinityScrollUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={SimpleMessageWithServiceInterfaceDtoInfinityScrollDetail} />
      <ErrorBoundaryRoute path={match.url} component={SimpleMessageWithServiceInterfaceDtoInfinityScroll} />
    </Switch>
  </>
);

export default Routes;
