<template>
  <div class="sidebar">
      <query-button class="button" :button-text="'I need information about something in Pathway.'" />
      <query-button class="button" :button-text="'I need information about the curriculum.'" />
      <query-button class="button" :button-text="'What\'s on the calendar today?'" />
      <query-button class="button" :button-text="'Where can I learn more about Java?'" />
      <query-button class="button" :button-text="'Where can I learn more about Vue.js?'" />
      <button class="button" v-on:click="logout()" :disabled="$store.state.nameOfCurrentUser==''">
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

.button {
    font-family: 'Roboto', sans-serif;
    background-color: #F5F7F3;
    border: none;
    color: #1F2B4A;
    text-align: center;
    border-radius: 4px;
    margin: 5px;
    width: 90%;
}

.button:hover {
    background-color: white;
    color: #1F2B4A;
}

.button:disabled,
.button[disabled] {
    background-color: #F5F7F3;
}
</style>