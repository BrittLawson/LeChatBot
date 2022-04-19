<template>
  <body class="pathway-container">
      <div id="icon">
          <img src="../img/TechElevator_PBS_RGB_ccexpress.png">
      </div>    
      <div id="header">
        <h1>le chat bot.</h1>
      </div>
      <div id="pathway-content">
          <pathway-info v-if="isPathway"/>
          <employer-follow-up-info v-if="isEmployerFollowUp" />
          <interview-fashion-info v-if="isInterviewFashion" />
          <interview-prep-info v-if="isInterviewPrep" />
          <star-questions-info v-if="isStarQuestions" />
      </div>
      <div id="pathway-chatbot">
          <chat-bot-container />
      </div>
  </body>
</template>

<script>
import ChatBotContainer from './ChatBotContainer.vue'
import EmployerFollowUpInfo from './EmployerFollowUpInfo.vue'
import InterviewFashionInfo from './InterviewFashionInfo.vue'
import InterviewPrepInfo from './InterviewPrepInfo.vue'
import PathwayInfo from './PathwayInfo.vue'
import StarQuestionsInfo from './StarQuestionsInfo.vue'
export default {
    name: "pathway-container",
    components: {
        ChatBotContainer,
        PathwayInfo,
        EmployerFollowUpInfo,
        InterviewFashionInfo,
        InterviewPrepInfo,
        StarQuestionsInfo
    },
    computed: {
        isPathway() {
            return this.$route.name === 'Pathway'
        },
        isEmployerFollowUp() {
            return this.$route.name === 'EmployerFollowUp';
        },
        isInterviewPrep() {
            return this.$route.name === 'InterviewPrep';
        },
        isInterviewFashion() {
            return this.$route.name === 'InterviewFashion';
        },
        isStarQuestions() {
            return this.$route.name === 'StarQuestions';
        }
    }

}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Playfair+Display:ital@1&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap');

.pathway-container {
    height: 95vh;
    display: grid;
    grid-template-columns: 1fr 2fr 3fr;
    grid-template-rows: 15vh 1fr;
    grid-template-areas: 
        "icon header header"
        "content content chatbot";    
}

#icon {
    height: 100%;
    grid-area: icon;
    background-color: #04ACF4;
    text-align: center
}

#icon > img {
    max-height: 100%;
    max-width: 100%;
    object-fit: contain;
}

#header {
    height: 100%;
    grid-area: header;
    background-color: #04ACF4;
    display: flex;
    align-items: center;
}

#pathway-content {
    grid-area: content;
    padding-top: 10px;
    padding-left: 10px;
    background-color: #F5F7F3;
    overflow-y: scroll;
    font-family: 'Roboto', sans-serif;
    color: #1F2B4A;
    border: 1px solid #1F2B4A;
}

#pathway-chatbot {
    grid-area: chatbot;
    padding-top: 10px;
    padding-left: 10px;
    background-color: #F5F7F3;
    font-family: 'Roboto', sans-serif;
    color: #1F2B4A;
    border: 1px solid #1F2B4A;
}

.content-container {
        height: 100%;
    }

.bot-container {
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }


.header {
    height: 100%;
    grid-area: header;
    background-color: #04ACF4;
    display: flex;
    align-items: center;
}

#header > h1 {
    color: #F5F7F3;
    font-family: 'Playfair Display', serif;
    font-size: 12vh;
    padding-left: 5%;
    height: 100%;
    width: 100%;
}

button {
    background-color: white;
    color: #1F2B4A;
    border: 2px solid #1F2B4A;
    height: 10vh;
    min-width: 150px;
    max-width: 60vh;
    border-radius: 4px;
    font-size: 2.5vh;
    margin-top: 1vh;
    margin-bottom: 1vh;
    margin-left: 1vh;
    margin-right: 1vh;
}

.bubble {
    font-size: 2.5vh;
    color: #F5F7F3;
    border-radius: 8px;
    flex-grow: 1;
    margin-left: 20px;
    margin-right: 20px;
    padding: 5px;
    display: inline-flex;
    justify-content: center;
    align-items: center;
    text-align: center;
  }

button:hover {
    background-color: #04ACF4;
    color: white;
}

button:disabled,
button[disabled] {
    background-color: #F5F7F3;
    color: #1F2B4A;
}

#pathway-topic-container {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
}

.pathway-topic-button {
    width: 70vh;
}

.button-footer {
    text-align: center;
}


</style>