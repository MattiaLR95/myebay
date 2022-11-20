package it.prova.myebay.repository.repository.acquisto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import it.prova.myebay.model.Acquisto;

public class CustomAcquistoRepositoryImpl implements CustomAcquistoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Acquisto> findByExample(Acquisto example) {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<String> whereClauses = new ArrayList<String>();

		StringBuilder queryBuilder = new StringBuilder(
				"select a from Acquisto a inner join a.utenteAcquirente u where a.id = a.id ");

		if (StringUtils.isNotEmpty(example.getDescrizione())) {
			whereClauses.add(" a.descrizione  like :descrizione ");
			parameterMap.put("descrizione", "%" + example.getDescrizione() + "%");
		}
		if (example.getData() != null) {
			whereClauses.add(" a.data >= :data ");
			parameterMap.put("data", example.getData());
		}
		if (example.getPrezzo() != null) {
			whereClauses.add(" a.prezzo = :prezzo ");
			parameterMap.put("prezzo", example.getPrezzo());
		}

		whereClauses.add("u.id = :utente_id");
		parameterMap.put("utente_id", example.getUtenteAcquirente().getId());

		queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Acquisto> typedQuery = entityManager.createQuery(queryBuilder.toString(), Acquisto.class);

		for (String key : parameterMap.keySet()) {
			typedQuery.setParameter(key, parameterMap.get(key));
		}

		return typedQuery.getResultList();
	}

}
