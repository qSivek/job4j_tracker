package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    /**
     * Хранение пользователей осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя которого нужно добавить.
     * Если пользователь уже есть в системе, то добавление не происходит.
     *
     * @param user пользователь, которого нужно добавить
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из хранилища по параметру паспорта.
     *
     * @param passport паспорт пользователя которого хотим удалить.
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Данный метод добавляет новый счет к пользователю.
     * Если у пользователя есть такой же счет, то добавление не происходит
     *
     * @param passport паспорт пользователя которому хотим добавить счет
     * @param account  счет пользователя который нужно добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод ищет пользователя по параметру паспорта.
     *
     * @param passport паспорт пользователя которого хотим найти
     * @return возвращает найденного пользователя или null если пользователь не найден
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(x -> passport.equals(x.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет счет пользователя по параметру паспорта и номеру счета
     *
     * @param passport  паспорт пользователя, аккаунт которого хотим найти
     * @param requisite номер счета который хотим найти у пользователя
     * @return возвращает счет пользователя или null если он не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        return users.get(user).stream()
                .filter(x -> x.getRequisite().equals(requisite))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод предназначен для перевода денежных средств с одного счета на другой
     * Если счет не найден или не хватает денежных средств, метод возвращает {@code false}
     *
     * @param srcPassport   паспорт пользователя со счета которого осуществляется перевод
     * @param srcRequisite  номер счета пользователя со счета которого осуществляется перевод
     * @param destPassport  паспорт пользователя на счет которого осуществляется перевод
     * @param destRequisite номер счета пользователя на который осуществляется перевод
     * @param amount        количество денежных средств которые нужно перевести
     * @return {@code true} если перевод успешен
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && destAcc != null
                && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            rsl = true;
        }

        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}