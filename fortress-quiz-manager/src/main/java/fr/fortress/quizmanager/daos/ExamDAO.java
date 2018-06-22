package fr.fortress.quizmanager.daos;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import fr.fortress.quizmanager.model.Exam;
import fr.fortress.quizmanager.services.WhereClauseBuilder;

@Repository
public class ExamDAO extends GenericORM_DAO_Abstract<Exam> {
	

	@Inject
	@Named("examQuery")
	String queryExam;

	private static final Logger LOGGER = LogManager.getLogger(ExamDAO.class);

	public void createExam(Exam exam) {

		this.createRecord(exam);
	}

	public void updateExam(Exam exam) {

		this.updateRecord(exam);
	}

	public void deleteExam(Exam exam) {

		this.deleteRecord(exam);
	}

	/**
	 * Search for the list of all application user record as list of the application
	 * user class that is passed as the parameter
	 * 
	 * @param applicationUser
	 * @return returns a list of application users.
	 */
	public List<Exam> getByExamNamePassword(Exam exam) {

		List<Exam> userList = null;

		try {

			userList = this.searchRecord(exam);

		} catch (Exception e) {
			// handle exception
			LOGGER.error(
					"Error searching for application users recordr with error message: " + e.getMessage().toString());
		}

		return userList;
	}

	public List<Exam> getListOfAllExams(Exam exam){
		
		List<Exam> examList = this.getListOfRecord(exam);
		return examList;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	protected WhereClauseBuilder getWhereClauseBuilder(Exam entity) {

		final WhereClauseBuilder<Exam> wcb = new WhereClauseBuilder<>();
		wcb.setQueryString(queryExam);

		try {

			// let the whereclausebuilder generate this map thanks to introspection
			final Map<String, Object> parameters = new LinkedHashMap<>();

			parameters.put("examTitle", entity.getExamTitleName());
			parameters.put("examId", entity.getExamId());
			parameters.put("classId", entity.getClass());
			
			wcb.setParameters(parameters);

		} catch (Exception e) {
			// handle exception
			LOGGER.error(
					"Error searching for application user record with error message: " + e.getMessage().toString());
		}

		return wcb;
	}

}
