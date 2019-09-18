package org.restlet.contacto.webapi.common;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

/**
 * The resource associated to a contact.
 */
public interface ContactoResource {

    @Get
    public Event retrieve();

    @Put
    public void store(Event contact);

    @Delete
    public void remove();

}
