<template>
  <div class="sidebar">
      <query-button :button-text="'I need information about something in Pathway.'" />
      <query-button :button-text="'I need information about the curriculum.'" />
      <query-button :button-text="'What\'s on the calendar today?'" />
      <query-button :button-text="'Where can I learn more about Java?'" />
      <query-button :button-text="'Where can I learn more about Vue.js?'" />
      <button class="query-button" v-on:click="logout()" :disabled="$store.state.nameOfCurrentUser==''">
        <p>I'd like to log out, please!</p>    
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