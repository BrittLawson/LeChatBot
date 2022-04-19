<template>
<div class="pathway-container">
  <header class="pathway-header">
    <h1>Welcome to Pathway!</h1>
  </header>
  <pathway-info id="pathway"/>
  <chat-bot-container id="chatbot"/>
</div>
</template>

<script>
import ChatBotContainer from '@/components/ChatBotContainer.vue';
import PathwayInfo from '@/components/PathwayInfo.vue';

export default {
  components: {
    ChatBotContainer,
    PathwayInfo
  }
}
</script>
  

<style style="scoped">

  #pathway {
    grid-area: pathway;
    margin: 1%;
  }
  #chatbot {
    grid-area: chatbot;
    margin: 1%;
  }
  .pathway-header {
    grid-area: pathway-header;
    background-color: #04ACF4;
    align-items: center;
  }
  .pathway-container {
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-rows: 1fr 3fr;
    grid-template-areas:  "pathway-header pathway-header"
                          "pathway chatbot";
                          
  }
  

</style>