import { createStore } from "vuex"
import institutions from "./institutions"
import accounts from "./accounts"



export default createStore({
    state: {
        loading: false
    },
    getters: {
        isLoading: state => state.loading
    },
    actions: {
        SET_LOADING({ commit }, isLoading) {
            commit('_setLoading', isLoading)
        }
    },
    mutations: {
        _setLoading(state, payload) {
            state.loading = payload
        }
    },

    modules: {
        institutions,
        accounts
    }
})