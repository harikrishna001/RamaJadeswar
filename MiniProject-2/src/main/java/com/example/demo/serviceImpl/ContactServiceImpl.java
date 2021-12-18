package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	
	
	private ContactRepository contactRepo;
	
	
	/*CREATE CONSTRUCTOR emdukamte serviceclass loki repository object inject depend avutahdi kada oka object imko object meda amdukani ok
	
	amte manually ga inject chesthunnam ala kakumda pinacraete chesam kada variable lada contactRepository dani meda @Autowired pedithe kimda constrcutor create cheyaballadu kani sir manually ga chupisthunnadu ok */
	 public ContactServiceImpl(ContactRepository contactRepo) {
	
		 this.contactRepo=contactRepo;
	}
	
	//embded database vadam demtlo [http://localhost:9010/h2-console]
	
	
	// http://localhost:9010/loadForm     save avvataniki eyokka URL ok.
	@Override
	public boolean saveContact(Contact contact) {
		
		Contact savedEntity=	contactRepo.save(contact);
		
		if(savedEntity!=null && savedEntity.getContactId()!=null)
		{
			return true;
		}
		
		return false;
	}

	
	@Override
	public List<Contact> getAllContacts() {
		
		List<Contact> contacts=	contactRepo.findAll();
		
		return contacts;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		
	Optional<Contact> findById=	contactRepo.findById(contactId);
	
	if(findById.isPresent())
	{
		return findById.get(); // recorde vumte ayokka record ni get chesi return cheyali user ki ok.
	}
		return null;   // oka vela record lakapothe it return null ok.
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		
	boolean existbyId=	contactRepo.existsById(contactId);
	
	
	if(existbyId)
	{
		contactRepo.deleteById(contactId);
		
		return true;
	}
	
		return false;
	}

}
