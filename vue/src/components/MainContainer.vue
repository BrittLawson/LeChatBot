<template>
  <body class="main-container">
      <div class="icon">
          <img src="https://files.zohopublic.com/public?x-service=LiveDesk&event-id=1546460094411_364983000000002043&x-cli-msg=%7B%22x-siq-filetype%22%3A%22fgravatar%22%2C%22x-siq-lsid%22%3A%22364983000000002043%22%2C%22x-siq-soid%22%3A%22670693202%22%2C%22x-siq-ispreview%22%3Afalse%2C%22x-siq-pfname%22%3A%22Mark%20-%20blue%20-%20white%20back.jpg%22%2C%22x-siq-downloadtype%22%3A%22default%22%7D" alt="">
      </div>    
      <div class="header">
        <h1>le chat bot.</h1>
      </div>
      <div class="sidebar">
          <sidebar />
      </div>
      <div class="content">
          <chat-bot-container />
      </div>
      
      
  </body>
</template>

<script>
import Sidebar from '@/components/Sidebar';
import ChatBotContainer from '@/components/ChatBotContainer.vue';

export default {
    name: "main-container",
    components: {
        Sidebar,
        ChatBotContainer
    }
}
</script>

<style style="scoped">
@import url('https://fonts.googleapis.com/css2?family=Playfair+Display:ital@1&display=swap');

.main-container {
    height: 95vh;
    display: grid;
    grid-template-columns: 1fr 5fr;
    grid-template-rows: 100px 3fr;
    grid-template-areas: 
        "icon header"
        "sidebar content";
}

.icon {
    grid-area: icon;
    background-color: #04ACF4;
    display: flex;
    justify-content: center
}

img {
    max-height: 100%;
    max-width: 100%;
    object-fit: cover;
}

.header {
    grid-area: header;
    background-color: #04ACF4;
    display: flex;
    align-items: center;
}

.content {
    grid-area: content;
    padding-top: 25px;
    padding-left: 5%;
}

h1 {
    color: #F5F7F3;
    font-family: 'Playfair Display', serif;
    font-size: 4em;
    padding-left: 5%;
}

</style>