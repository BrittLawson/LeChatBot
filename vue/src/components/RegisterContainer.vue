<template>
  <div class="content-container">
  <div class="bot-container">
    <bot-speech-bubble v-if="!registrationErrors" :speechText="'Choose a username and password, meow!'" />
    <bot-speech-bubble v-if="registrationErrors" :speechText="registrationErrorMsg" /> 
    <form class="form-register" @submit.prevent="register">
        

      <div class="input-container">
         <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
        />
        
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        
        <input
          type="password"
          id="confirmPassword"
          class="form-control"
          placeholder="Confirm Password"
          v-model="user.confirmPassword"
          required
        />
      
      </div>

      <div class="button-container">
        <button class="register-button" type="submit">Sign up</button>
        <br>
        <button class="register-button" v-on:click="goToLogin()">Actually, I already have an account!</button>
      </div>
    </form>
    </div>
  </div>
  

</template>

<script>
import authService from '../services/AuthService';
import BotSpeechBubble from './BotSpeechBubble.vue';

export default {
    name: "register-container",
    components: {
        BotSpeechBubble
    },
    data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'Meow! Something went wrong.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Meow-oh! Your password didn\t match the password confirmation!';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Meow! Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'Meow! There were problems registering this user.';
    },
    goToLogin() {
        this.$router.push("/login");
    }
  },

}
</script>

<style>

.input-container {
    display: flex;
}

.button-container {
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
}

.form-register {
    height: 100%;
    margin-top: 15px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
}

.form-control {
    height: 50px;  
    font-size: 1.5em;
    margin: 15px;
}

.register-button {
  margin: 10px;
}



</style>