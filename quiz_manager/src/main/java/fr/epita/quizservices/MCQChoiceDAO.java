package fr.epita.quizservices;

import java.util.LinkedHashMap;

import fr.epita.quiz.datamodel.MCQChoice;



public class MCQChoiceDAO extends GenericORM_DAO_Abstract<MCQChoice> {

	@Override
	protected WhereClauseBuilder<MCQChoice> getWhereClauseBuilder(MCQChoice entity) {
		final WhereClauseBuilder<MCQChoice> whereClauseBuilder = new WhereClauseBuilder<>();
		whereClauseBuilder.setParameters(new LinkedHashMap<>());

		// TODO : load from configuration
		final String query = "from MCQChoice";

		whereClauseBuilder.setQueryString(query);
		return whereClauseBuilder;

	}
}
