package org.restlet.contacto.webapi.server;

import org.restlet.contacto.webapi.common.Guestbook;
//import org.restlet.contacto.webapi.common.Address;
import org.restlet.contacto.webapi.common.Event;
import org.restlet.contacto.webapi.common.ContactoResource;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import static com.googlecode.objectify.ObjectifyService.ofy;



import com.google.appengine.api.datastore.DatastoreService;

import com.google.appengine.api.datastore.DatastoreServiceFactory;

import com.google.appengine.api.datastore.Entity;

//import com.google.appengine.api.datastore.Key;

import com.google.appengine.api.datastore.KeyFactory;

import java.util.Date;

import java.util.List;


import com.googlecode.objectify.Key;



import com.googlecode.objectify.ObjectifyService;





/**
 * The server side implementation of the Restlet resource.
 */
public class ContactoServerResource extends ServerResource implements
        ContactoResource {

    private static volatile Event contact = new Event("Junio", "Scott", "Tiger", "From ContactoServerResource","linea 2","20010","Columbus","USA",54);

    
 

//String guestbookName = "Enero";
//Key<Guestbook> theBook = Key.create(Guestbook.class, guestbookName);



    @Delete
    public void remove() {
        contact = null;
    }

    @Get
    public Event retrieve() {
// Create the monthId --- used as key        
    String contactId = getAttribute("contactId");

    int monthId = 0;
switch (contactId) {
  case "Enero":
   monthId = 4;
   break;
  case "Febrero":
   monthId = 5;
   break;
  case "Marzo":
   monthId = 8;
   break;
  case "Abril":
   monthId = 1;
   break;
  case "Mayo":
   monthId = 9;
   break;
  case "Junio":
   monthId = 7;
   break;
  case "Julio":
   monthId = 6;
   break;
  case "Agosto":
   monthId = 2;
   break;
  case "Septiembre":
   monthId = 12;
   break;
  case "Octubre":
   monthId = 11;
   break;
  case "Noviembre":
   monthId = 10;
   break;
  case "Diciembre":
   monthId = 3;
   break;
  
   
 }

    List<Event> events = ObjectifyService.ofy()
                  .load()
                  .type(Event.class)
                  .limit(monthId)
                  .list();
    for(Event event:events) {
     contact = event;
    }   
    return contact;
    }

    @Put
    public void store(Event contact) {

        ObjectifyService.ofy().save().entity(contact).now();
    }

}
