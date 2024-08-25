import * as accountInfoService from '@/services/AccountInfoService'


export default {
    state: {
        requisitionId: '',
        requisitionLink: ''
    },
    getters: {
        getRequisitionId: state => state.requisitionId,
        getRequisitionLink: state => state.requisitionLink
    },
    actions: {
        async CREATE_ACCOUNT({ commit }, { id, maxDays }) {
            const requisition = await accountInfoService.createAccountRequisition(id, maxDays)
            commit('_setRequisition', requisition)
        }
    },
    mutations: {
        _setRequisition(state, { id, link }) {
            state.requisitionId = id
            state.requisitionLink = link
        }
    }
}