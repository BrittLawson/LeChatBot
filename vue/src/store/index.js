import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    nameOfCurrentUser: '',
    currentQueryString: '',
    currentResponseObject: {
      message: "",
      links: []
    },
    currentCat: {
      src: "oliver-talking-2.gif",
      alt: "Oliver the cat",
      name: "Oliver"
    },
    cats: {
      index: 1,
      catsArray: 
        [
          {
            src: "oliver-talking-2.gif",
            alt: "Oliver the cat",
            name: "Oliver"
          },
          {
            src: "b.gif",
            alt: "Elmo the cat",
            name: "Elmo"
          },
          {
            src: "c.gif",
            alt: "Roosevelt the cat",
            name: "Roosevelt"
          },
          {
            src: "e.gif",
            alt: "Roo the cat",
            name: "Roo"
          },
          {
            src: "a.gif",
            alt: "Chewy the cat",
            name: "Chewy"
          }
        ]
      },
      pathwayTopics: [
        {
          id: 1,
          routeName: "EmployerFollowUp",
          linkText: "Learn about how best to follow up with an employer."
        },
        {
          id: 2,
          routeName: "InterviewFashion",
          linkText: "Dress to impress for your interviews."
        },
        {
          id: 3,
          routeName: "InterviewPrep",
          linkText: "Prepare for that interview you're so excited about."
        },
        {
          id: 4,
          routeName: "StarQuestions",
          linkText: "Learn how to ace those STAR questions."
        }
      ]
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_USER_NAME(state, name) {
      state.nameOfCurrentUser = name;
    },
    SET_QUERY_STRING(state, queryString) {
      state.currentQueryString = queryString;
    },
    SET_RESPONSE_OBJECT(state, response) {
      state.currentResponseObject = response.data;
    },
    SWITCH_CAT(state) {
      state.currentCat = state.cats.catsArray[state.cats.index];
      if (state.cats.index < state.cats.catsArray.length - 1) {
        state.cats.index = state.cats.index + 1;
      } else {
        (state.cats.index = 0);
      }
    }
  }
})
