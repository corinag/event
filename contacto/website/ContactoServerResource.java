/**
 * Copyright 2005-2014 Restlet
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: Apache 2.0 or or EPL 1.0 (the "Licenses"). You can
 * select the license that you prefer but you may not use this file except in
 * compliance with one of these Licenses.
 * 
 * You can obtain a copy of the Apache 2.0 license at
 * http://www.opensource.org/licenses/apache-2.0
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://restlet.com/products/restlet-framework
 * 
 * Restlet is a registered trademark of Restlet S.A.S.
 */

package org.restlet.contacto.website;

import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.restlet.data.LocalReference;
import org.restlet.data.MediaType;

import org.restlet.contacto.webapi.common.Event;



import org.restlet.data.Form;
import org.restlet.data.Parameter;

import org.restlet.ext.fileupload.RestletFileUpload;
import org.restlet.ext.freemarker.TemplateRepresentation;
import org.restlet.representation.InputRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;


/**
 * Resource corresponding to a mail received or sent with the parent mail
 * account. Leverages FreeMarker template engine.
 */

public class ContactoServerResource extends ServerResource {

    
@Get
    
public Representation retrieve() {
        
// Create the contacto URI inside the API application
        
String contactId = getAttribute("contactId");
                
String contactApiUri = "riap://component/api/contacts/" + contactId;

        

// Optimal internal call using the server dispatcher
        
ClientResource cr = new ClientResource(contactApiUri);
 
// Not needed when using GWT
cr.setRequestEntityBuffering(true);             
Event contact = cr.get(Event.class);

   

   
// Load the FreeMarker template
               
Representation contactFtl = new ClientResource("war:///Contact.ftl").get();

// Wraps the bean with a FreeMarker representation
        
return new TemplateRepresentation(contactFtl, contact, MediaType.TEXT_HTML);
    
}

    

@Put
    
public void store(Form form) throws Exception {
        
   
 Event contact = new Event();  


for (Parameter entry : form) {

           
 switch (entry.getName()) {
  case "name":
   contact.setName(entry.getValue());
   break;
  case "title":
   contact.setTitle(entry.getValue());
   break;
  case "lastName":
   contact.setLastName(entry.getValue());
   break;
  case "age":
   contact.setAge(Integer.parseInt(entry.getValue()));
   break;
  case "line1":
   contact.setLine1(entry.getValue());
   break;
  case "line2":
   contact.setLine2(entry.getValue());
   break;
  case "zipcode":
   contact.setZipcode(entry.getValue());
   break;
  case "city":
   contact.setCity(entry.getValue());
   break;
  case "country":
   contact.setCountry(entry.getValue());
   break;
 }
//System.out.println(fileItem.getFieldName() + "=" + fileItem.getString());
 

//  contact.setHomeAddress(address);
         
//} else                
//attachment.write(System.out);
            
//}
  
    }

        



// Create the contacto URI inside the API application
        
String contactId = getAttribute("contactId");
                
String contactApiUri = "riap://component/api/contacts/" + contactId;

        

// Optimal internal call using the server dispatcher
        
ClientResource cr = new ClientResource(contactApiUri);
 
// Not needed when using GWT
cr.setRequestEntityBuffering(true);             
cr.put(contact);

     
}

}
