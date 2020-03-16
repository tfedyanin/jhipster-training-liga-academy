import React from 'react';
import MenuItem from 'app/shared/layout/menus/menu-item';
import { DropdownItem } from 'reactstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { Translate, translate } from 'react-jhipster';
import { NavLink as Link } from 'react-router-dom';
import { NavDropdown } from './menu-components';

export const EntitiesMenu = props => (
  <NavDropdown
    icon="th-list"
    name={translate('global.menu.entities.main')}
    id="entity-menu"
    style={{ maxHeight: '80vh', overflow: 'auto' }}
  >
    <MenuItem icon="asterisk" to="/simple-message">
      <Translate contentKey="global.menu.entities.simpleMessage" />
    </MenuItem>
    <MenuItem icon="asterisk" to="/simple-message-with-service">
      <Translate contentKey="global.menu.entities.simpleMessageWithService" />
    </MenuItem>
    <MenuItem icon="asterisk" to="/simple-message-with-service-interface">
      <Translate contentKey="global.menu.entities.simpleMessageWithServiceInterface" />
    </MenuItem>
    {/* jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here */}
  </NavDropdown>
);
