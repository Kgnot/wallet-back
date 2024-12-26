CREATE TABLE "Users"(
    "id_user" SERIAL NOT NULL,
    "nickname" VARCHAR(30) NOT NULL,
    "email" VARCHAR(70) NOT NULL,
    "password" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "Users" ADD PRIMARY KEY("id_user");
ALTER TABLE
    "Users" ADD CONSTRAINT "users_nickname_unique" UNIQUE("nickname");
ALTER TABLE
    "Users" ADD CONSTRAINT "users_email_unique" UNIQUE("email");
CREATE TABLE "Expenses"(
    "id_expense" SERIAL NOT NULL,
    "id_user" INTEGER NOT NULL,
    "type" VARCHAR(255) NOT NULL
);
CREATE INDEX "expenses_id_user_index" ON
    "Expenses"("id_user");
ALTER TABLE
    "Expenses" ADD PRIMARY KEY("id_expense");
CREATE TABLE "Expenses_history"(
    "id_expense_history" SERIAL NOT NULL,
    "id_expense" INTEGER NOT NULL,
    "id_expenses_type" INTEGER NOT NULL
);
ALTER TABLE
    "Expenses_history" ADD PRIMARY KEY("id_expense_history");
CREATE TABLE "Moods"(
    "id_mood" SERIAL NOT NULL,
    "id_user" INTEGER NOT NULL,
    "type" VARCHAR(255) NOT NULL
);
CREATE INDEX "moods_id_user_index" ON
    "Moods"("id_user");
ALTER TABLE
    "Moods" ADD PRIMARY KEY("id_mood");
CREATE TABLE "Denominations"(
    "id_denomination" SERIAL NOT NULL,
    "denomination" VARCHAR(10) NOT NULL
);
ALTER TABLE
    "Denominations" ADD PRIMARY KEY("id_denomination");
CREATE TABLE "Incomes"(
    "id_incomes" SERIAL NOT NULL,
    "id_user" INTEGER NOT NULL,
    "type" VARCHAR(255) NOT NULL
);
CREATE INDEX "incomes_id_user_index" ON
    "Incomes"("id_user");
ALTER TABLE
    "Incomes" ADD PRIMARY KEY("id_incomes");
CREATE TABLE "Incomes_history"(
    "id_income_history" SERIAL NOT NULL,
    "id_income" INTEGER NOT NULL
);
ALTER TABLE
    "Incomes_history" ADD PRIMARY KEY("id_income_history");
CREATE TABLE "Expenses_types"(
    "id_expense_type" SERIAL NOT NULL,
    "type" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "Expenses_types" ADD PRIMARY KEY("id_expense_type");
CREATE TABLE "Goals"(
    "id_goal" SERIAL NOT NULL,
    "id_user" INTEGER NOT NULL,
    "date" DATE NOT NULL,
    "id_goal_type" INTEGER NOT NULL
);
ALTER TABLE
    "Goals" ADD PRIMARY KEY("id_goal");
CREATE TABLE "Goals_types"(
    "id_goal_type" SERIAL NOT NULL,
    "type" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "Goals_types" ADD PRIMARY KEY("id_goal_type");
CREATE TABLE "Wallets"(
    "id_wallet" SERIAL NOT NULL,
    "wallet_type" VARCHAR(255) NOT NULL,
    "wallet_img_url" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "Wallets" ADD PRIMARY KEY("id_wallet");
CREATE TABLE "Balances"(
    "id_balance" SERIAL NOT NULL,
    "id_user" INTEGER NOT NULL,
    "id_wallet" INTEGER NOT NULL,
    "amount" FLOAT(53) NOT NULL
);
CREATE INDEX "balances_id_user_index" ON
    "Balances"("id_user");
ALTER TABLE
    "Balances" ADD PRIMARY KEY("id_balance");
CREATE TABLE "Profiles"(
    "id_profile" SERIAL NOT NULL,
    "id_user" INTEGER NOT NULL,
    "first_name" VARCHAR(255) NOT NULL,
    "last_name" VARCHAR(255) NOT NULL,
    "img" VARCHAR(255) NOT NULL,
    "description" TEXT NOT NULL
);
ALTER TABLE
    "Profiles" ADD PRIMARY KEY("id_profile");
CREATE TABLE "Transaction"(
    "id_transaction" SERIAL NOT NULL,
    "id_expenses_history" INTEGER NULL,
    "id_incomes_history" INTEGER NULL,
    "value" FLOAT(53) NOT NULL,
    "id_denomination" INTEGER NOT NULL,
    "date" DATE NOT NULL,
    "month" INTEGER NOT NULL,
    "year" INTEGER NOT NULL,
    "id_wallet" INTEGER NOT NULL,
    "id_user" INTEGER NOT NULL,
    "id_mood" INTEGER NOT NULL
);
CREATE INDEX "transaction_id_user_index" ON
    "Transaction"("id_user");
CREATE INDEX "transaction_id_wallet_index" ON
    "Transaction"("id_wallet");
CREATE INDEX "transaction_id_mood_index" ON
    "Transaction"("id_mood");
ALTER TABLE
    "Transaction" ADD PRIMARY KEY("id_transaction");
ALTER TABLE
    "Transaction" ADD CONSTRAINT "transaction_id_denomination_foreign" FOREIGN KEY("id_denomination") REFERENCES "Denominations"("id_denomination");
ALTER TABLE
    "Goals" ADD CONSTRAINT "goals_id_user_foreign" FOREIGN KEY("id_user") REFERENCES "Users"("id_user");
ALTER TABLE
    "Expenses_history" ADD CONSTRAINT "expenses_history_id_expense_foreign" FOREIGN KEY("id_expense") REFERENCES "Expenses"("id_expense");
ALTER TABLE
    "Transaction" ADD CONSTRAINT "transaction_id_expenses_history_foreign" FOREIGN KEY("id_expenses_history") REFERENCES "Expenses_history"("id_expense_history");
ALTER TABLE
    "Transaction" ADD CONSTRAINT "transaction_id_mood_foreign" FOREIGN KEY("id_mood") REFERENCES "Moods"("id_mood");
ALTER TABLE
    "Transaction" ADD CONSTRAINT "transaction_id_wallet_foreign" FOREIGN KEY("id_wallet") REFERENCES "Wallets"("id_wallet");
ALTER TABLE
    "Profiles" ADD CONSTRAINT "profiles_id_user_foreign" FOREIGN KEY("id_user") REFERENCES "Users"("id_user");
ALTER TABLE
    "Transaction" ADD CONSTRAINT "transaction_id_incomes_history_foreign" FOREIGN KEY("id_incomes_history") REFERENCES "Incomes_history"("id_income_history");
ALTER TABLE
    "Expenses" ADD CONSTRAINT "expenses_id_user_foreign" FOREIGN KEY("id_user") REFERENCES "Users"("id_user");
ALTER TABLE
    "Transaction" ADD CONSTRAINT "transaction_id_user_foreign" FOREIGN KEY("id_user") REFERENCES "Users"("id_user");
ALTER TABLE
    "Goals" ADD CONSTRAINT "goals_id_goal_type_foreign" FOREIGN KEY("id_goal_type") REFERENCES "Goals_types"("id_goal_type");
ALTER TABLE
    "Balances" ADD CONSTRAINT "balances_id_wallet_foreign" FOREIGN KEY("id_wallet") REFERENCES "Wallets"("id_wallet");
ALTER TABLE
    "Incomes_history" ADD CONSTRAINT "incomes_history_id_income_foreign" FOREIGN KEY("id_income") REFERENCES "Incomes"("id_incomes");
ALTER TABLE
    "Expenses_history" ADD CONSTRAINT "expenses_history_id_expenses_type_foreign" FOREIGN KEY("id_expenses_type") REFERENCES "Expenses_types"("id_expense_type");
ALTER TABLE
    "Moods" ADD CONSTRAINT "moods_id_user_foreign" FOREIGN KEY("id_user") REFERENCES "Users"("id_user");
ALTER TABLE
    "Balances" ADD CONSTRAINT "balances_id_user_foreign" FOREIGN KEY("id_user") REFERENCES "Users"("id_user");
ALTER TABLE
    "Incomes" ADD CONSTRAINT "incomes_id_user_foreign" FOREIGN KEY("id_user") REFERENCES "Users"("id_user");