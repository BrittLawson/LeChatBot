<template>
  <div class="sidebar">
      <button class="query-button" v-on:click="pathway()" :disabled="$store.state.nameOfCurrentUser==''">
        I need information about something in Pathway.  
      </button> 
      <query-button :button-text="'Tell me a joke!'" />
      <button class="query-button" v-on:click="events()">
        Tell me about some upcoming local events.   
      </button>
      <query-button :button-text="'Where can I learn more about Java?'" />
      <query-button :button-text="'Where can I learn more about Vue.js?'" />
      <button class="query-button" v-on:click="logout()" :disabled="$store.state.nameOfCurrentUser==''">
        I'd like to log out, please! 
      </button>    
  </div>
</template>

<script>
import QueryButton from '@/components/QueryButton';
export default {
    name: "sidebar",
    components: {
        QueryButton
    },
    methods: {
        logout () {
            this.$store.commit("SET_USER_NAME", '')
            this.$store.commit("LOGOUT");
            this.$router.push("/login");
        },
        pathway () {
            this.$router.push("/Pathway");
        },
        events () {
            let eventUrl = "https://www.meetup.com/find/?keywords=technology&location=us--pa--Pittsburgh&source=EVENTS";
            window.open(eventUrl, "_blank")
        }
        
    }

}
</script>

<style style="scoped">
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap');

.sidebar {
    background-color: #658FAE;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
    height: 100%;
}

.query-button {
    margin: 5px;
    width: 90%;
}


</style>