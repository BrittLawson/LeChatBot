<template>
  <div>
    <header>
      <h1>
        Behavioral Interviews and STAR Questions
      </h1>
      <p>
        Behavioral Interviews will be a big part of your job search as you begin applying for a job in 
        technology. Companies aren't just looking for someone who 'checks the boxes' in regard to technical 
        skills, they want someone who is a culture fit for their team and their company as well, which is why 
        they'll use the behavioral interview and/or phone screen to assess if you're a culture fit or not.
      </p>
    </header> 
    <section>
      <h2>
        Best Practices: Behavioral Interviews
      </h2>
      <h3>
        When answering behavioral questions, you should always follow these simple rules:
      </h3>
      <h4>Be specific</h4>
      <ul>
        <li>
          Provide a specific example of a situation that answers the question
        </li>
        <li>
          Do not be vague or generic
          <ul>
            <li>
              Avoid saying "That happened all the time at my old job..."
            </li>
          </ul>
        </li>
      </ul>
      <h4>
        Body language and non-verbals
      </h4>
      <ul>
        <li>
          Pause and think before answering
        </li>
        <li>
          Ask them to clarify the question
        </li>
        <li>
          If you really do not have an example, say, "That's a great question, and I'm sure I have a good 
          example, but can't think of it at the moment. Do you mind we come back that question?"
          <ul>
            <li>
              If they do not come back to it, give them an answer in your follow-up/thank you email
            </li>
          </ul>
        </li>
      </ul>
      <h4>
        Practice your STAR stories
      </h4>
      <ul>
        <li>
          Prepare example stories for each of these categories:
          <ul>
            <li>
              Teamwork and Collaboration
            </li>
            <li>
              Leadership
            </li>
            <li>
              Problem Solving Skills
            </li>
            <li>
              Communication and Handling Conflict
            </li>
            <li>
              Work Ethic and Initiative
            </li>
            <li>
              Failures
            </li>
          </ul>
        </li>
        <li>
          Write down 1-2 examples for each question and practice sharing that story
        </li>
        <li>
          Make sure you hit each point of the STAR:
          <ul>
            <li>
              Situation - What was the situation at hand? Provide some background information.
            </li>
            <li>
              Task - What needed to be done in the situation?
            </li>
            <li>
              Action - What action did you actually take?
            </li>
            <li>
              Result - What happened as a result, how did you and others react, and what did you learn?
            </li>
          </ul>
        </li>
      </ul>
    </section>
    <section>
      <h3>
        STAR Example Questions
      </h3>
      <ul>
        <li>
          Describe a time when you cooperated with someone outside of your team/department/group in an activity 
          that turned out to benefit both teams/departments/groups. 
        </li>
        <li>
          Describe a situation in which you made an effort to repair an important relationship. What made this 
          relationship important to you and the business?
        </li>
        <li>
          We've all had to make a decision with limited information. Tell me about a time this happened to you.
        </li>
        <li>
          At one time we all thought we handled a problem successfully only to find we had only affected a 
          symptom of a larger problem. Can you give me an example of when this happened to you?
        </li>
        <li>
          Give an example of a time when you were able to apply existing technology or knowledge in a new 
          way to solve a problem.
        </li>
        <li>
          Can you give me a recent example of when you suggested a teammate try a different way to solve a 
          problem, but it didn't work as well as the original approach?
        </li>
        <li>
          Tell me about the ways in which you have worked with group members to develop new and innovative 
          ideas to solve business problems. Give me a recent example.
        </li>
        <li>
          Tell me about a recent time when you thought, "There's got to be a better way...", and then you found one.
        </li>
        <li>
          Describe a time when you had difficulty convincing a work team to implement changes. How did you 
          address their issues?
        </li>
        <li>
          Describe your biggest disappointment at work. Why was this so disappointing for you?
        </li>
        <li>
          Tell me about a time when you were particularly satisfied with your work situation. Why was this 
          situation so gratifying?
        </li>
        <li>
          Give me an example of a time when you worked with a group/team to determine project responsibilities. 
          What difficulties or issues came up?
        </li>
        <li>
          Think of someone from another department with whom you've worked with who would say you're a good 
          partner. Why would that person say that? Provide examples.
        </li>
        <li>
          Describe the steps you took to identify or understand a complicated problem you have had to deal 
          with on your job.
        </li>
        <li>
          Describe a time when you weighed the pros and cons of a situation and decided not to take action, 
          even though you were under pressure to do so.
        </li>
        <li>
          Describe a time at work when you helped a coworker learn to use a new technology tool.
        </li>
        <li>
          Can you think of a time when you recommended a solution that was or wasn't accepted by the 
          customer or internal group? What was the reason?
        </li>
        <li>
          Tell me about one of the most difficult meetings you've had where you needed to gain someone's 
          agreement or commitment to an idea or plan.
        </li>
        <li>
          Give me an example of a time when you were able to get someone from outside your workgroup to 
          cooperate with you on an important initiative or project.
        </li>
        <li>
          Describe a situation in which you had to use a different approach because your initial approach 
          failed to persuade others.
        </li>
      </ul>
    </section>
    <footer class="button-footer">
        <button class="pathway-topic-button" v-on:click="pathway()" :disabled="$store.state.nameOfCurrentUser==''">
        Take me back to the Pathway home page.  
        </button>
        <br>
        <button class="pathway-topic-button" v-on:click="home()" :disabled="$store.state.nameOfCurrentUser==''">
        Take me back to the main Chatbot home page.  
      </button>
      </footer>
  </div>
</template>

<script>
export default {
  name: "star-questions-info",
  methods: {
    pathway () {
            this.$router.push("/Pathway");
        },
    home () {
      this.$router.push("/")
    }
  }

}
</script>

<style>

</style>