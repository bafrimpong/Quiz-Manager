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
import fr.fortress.quizmanager.services.SQLWhereClauseBuilder;

@Repository
public class ExamDAO extends GenericORM_DAO_Abstract<Exam> {

	@Inject
	@Named("examQuery")
	String queryExam;

	@Inject
	@Named("examByNameQuery")
	String getExamByTitleName;

	/*
	 * @Inject
	 * 
	 * @Named("allExamsQuery") String getAllExamsQuery;
	 */

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
	public List<Exam> getExamsByExamId(Exam exam) {

		List<Exam> examList = null;

		try {

			examList = this.searchRecord(exam);

		} catch (Exception e) {
			// handle exception
			LOGGER.error(
					"Error searching for application users recordr with error message: " + e.getMessage().toString());
		}

		return examList;
	}

	public List<Exam> getExamsByExamName(Exam exam) {

		List<Exam> examList = null;

		try {

			examList = this.searchRecord(exam);

		} catch (Exception e) {
			// handle exception
			LOGGER.error(
					"Error searching for application users recordr with error message: " + e.getMessage().toString());
		}

		return examList;
	}

	public List<Exam> getListOfAllExams(Exam exam) {

		List<Exam> examList = this.getListOfRecord(exam, queryExam);
		return examList;
	}

	/**
	 * Gets an exam record bases on the exam title name field
	 * @param exam
	 * @return returns a list of the exam object
	 */
	public List<Exam> getListOfExamByExamTitleName(Exam exam) {

		List<Exam> studentList = this.searchRecord(exam);
		return studentList;
	}


	
	/*@SuppressWarnings("rawtypes")
	@Override
	protected SQLWhereClauseBuilder getWhereClauseBuilder(Exam entity) {

		final SQLWhereClauseBuilder<Exam> wcb = new SQLWhereClauseBuilder<>();
		wcb.setQueryString(getExamByTitleName);

		try {

			// let the whereclausebuilder generate this map thanks to introspection
			final Map<String, Object> parameters = new LinkedHashMap<>();

			parameters.put("examTitleName", entity.getExamTitleName());
			parameters.put("examId", entity.getExamId());
			// parameters.put("classId", entity.getClass());

			wcb.setParameters(parameters);

		} catch (Exception e) {
			// handle exception
			LOGGER.error(
					"Error searching for application user record with error message: " + e.getMessage().toString());
		}

		return wcb;
	}*/
	
	@Override
	protected SQLWhereClauseBuilder<Exam> getWhereClauseBuilder(Exam exam) {
		
		final SQLWhereClauseBuilder<Exam> wcb = new SQLWhereClauseBuilder<>();
		wcb.setQueryString(getExamByTitleName);

		// TODO as bonus : let the whereclausebuilder generate this map thanks to introspection
		final Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("examTitleName", exam.getExamTitleName());

		wcb.setParameters(parameters);
		return wcb;
	}

}
