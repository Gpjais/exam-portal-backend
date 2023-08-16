package com.exam.examserver.entity.exam;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long question_id;
	private String question_content;
	private String option_one;
	private String option_two;
	private String option_three;
	private String option_four;
	private String answer;
	

	@ManyToOne(fetch = FetchType.EAGER)
	private Quiz quiz;

	public Question() {
		super();
	}

	

	public Question(long question_id, String question_content, String option_one, String option_two,
			String option_three, String option_four, String answer) {
		super();
		this.question_id = question_id;
		this.question_content = question_content;
		this.option_one = option_one;
		this.option_two = option_two;
		this.option_three = option_three;
		this.option_four = option_four;
		this.answer = answer;
	}

	public Question(String question_content, String option_one, String option_two, String option_three,
			String option_four, String answer) {
		super();
		this.question_content = question_content;
		this.option_one = option_one;
		this.option_two = option_two;
		this.option_three = option_three;
		this.option_four = option_four;
		this.answer = answer;
	}

	public long getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(long question_id) {
		this.question_id = question_id;
	}

	public String getQuestion_content() {
		return question_content;
	}

	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}

	public String getOption_one() {
		return option_one;
	}

	public void setOption_one(String option_one) {
		this.option_one = option_one;
	}

	public String getOption_two() {
		return option_two;
	}

	public void setOption_two(String option_two) {
		this.option_two = option_two;
	}

	public String getOption_three() {
		return option_three;
	}

	public void setOption_three(String option_three) {
		this.option_three = option_three;
	}

	public String getOption_four() {
		return option_four;
	}

	public void setOption_four(String option_four) {
		this.option_four = option_four;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", question_content=" + question_content + ", option_one="
				+ option_one + ", option_two=" + option_two + ", option_three=" + option_three + ", option_four="
				+ option_four + ", answer=" + answer + ", quiz=" + quiz + "]";
	}

}
