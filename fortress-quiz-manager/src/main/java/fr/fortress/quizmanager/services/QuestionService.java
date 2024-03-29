
package fr.fortress.quizmanager.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import fr.fortress.quizmanager.daos.MCQChoiceDAO;
import fr.fortress.quizmanager.daos.QuestionDAO;
import fr.fortress.quizmanager.model.MCQChoice;
import fr.fortress.quizmanager.model.Question;

@Component
public class QuestionService {

	@Inject
	private MCQChoiceDAO mcqChoiceDAO;

	@Inject
	private QuestionDAO questionDAO;

	@Inject
	private SessionFactory factory;

	public boolean createQuestion(Question question) {

		if (question.getQuestionTitle().equals(null) || question.getQuestionTitle().equals("")
				|| question.getExamInQuestion().getExamId() <= 0 || question.getQuestionType().equals(null)
				|| question.getQuestionTitle().equals("")) {

			return false;
		} else {
			questionDAO.createQuestion(question);
			return true;
		}

	}

	public boolean updateQuestion(Question question) {

		if (question.getQuestionTitle().equals("") || question.getExamInQuestion().getExamId() <= 0) {

			return false;
		} else {
			questionDAO.updateQuestion(question);
			return true;
		}

	}

	public List<Question> getAllQuestions(Question question) {

		List<Question> questionList = questionDAO.getListOfAllQuestions(question);
		return questionList;
	}

	// @Transactional
	// TODO check that in a further lecture
	public void deleteQuestion(Question question) {

		final Transaction transaction = factory.openSession().beginTransaction();

		final MCQChoice criteria = new MCQChoice();
		criteria.setQuestion(question);

		final List<MCQChoice> choicesList = mcqChoiceDAO.searchRecord(criteria);
		for (final MCQChoice choice : choicesList) {
			mcqChoiceDAO.deleteRecord(choice);
		}
		questionDAO.deleteRecord(question);
		transaction.commit();
	}

}
