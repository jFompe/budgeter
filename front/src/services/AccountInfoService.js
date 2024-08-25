

const BASE_PATH = 'http://localhost:8080'
const REDIRECT_URI = 'http://localhost:3000/dashboard'



export async function getInstitutions(countryId='ES') {
    const institutions = await fetch(`${BASE_PATH}/api/v1/institutions?countryId=${countryId}`)
    return institutions.json()
}


export async function createAccountRequisition(institutionId, maxDays = 90) {
    const body = {
        institutionId: institutionId,
        maxTransactionDays: maxDays,
        redirectUri: REDIRECT_URI,
        lang: 'ES'
    }

    const response = await fetch(`${BASE_PATH}/api/v1/accounts`, {
        method: 'POST',
        body: JSON.stringify(body),
        headers: {
            "Content-Type": "application/json",
        }
    })    

    return response.json()
}


export async function getAccounts(requisitionId) {
    const accounts = await fetch(`${BASE_PATH}/api/v1/accounts/${requisitionId}`)
    return accounts.json().accounts
}


export async function getTransactions(accountId) {
    const transactions = await fetch(`${BASE_PATH}/api/v1/accounts/${accountId}/transactions`)
    return transactions.json()
}

