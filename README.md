# Easurance 🏢

Webová aplikace vytvořena ve Spring Bootu. Aplikace umožňuje CRUD správu osob a jejich pojištění. V roli admina taky správu pojišťoven.

## Klíčové vlastnosti 🎯

- Aplikace podporuje uživatelské role (Administrátor, zaměstnanec, návštěvník).
- Aplikace obsahuje kompletní správu (CRUD) pojištěných (např. "Jan Novák") a jejich pojištění (např. "pojištění bytu").
- Dané entity jsou uloženy v SQL databázi (JPA - Hibernate).
- Osoby a pojištění jsou provázány vazbou 1:N, pojištění a pojišťovny taky mají vazbu 1:N (při odstranění osoby se odstraní i její pojištění).
- Pro třídění a vyhledávání dat v tabulkách na stránce byla použita knihovna jQuery DataTables.
- Aplikace je plně responzivní.
- Všechny vstupy jsou validovány (Hibernate Validator).

## Video 🎥

https://github.com/JagosMarek/easurance/assets/128280984/7223ceea-8e05-4d50-bc7a-912d6cfb50cb

## Screenshots 📷

![photo1](https://github.com/JagosMarek/easurance/assets/128280984/536281d1-edf3-4019-820c-a2494c797b55)

<p align="center">
 <img src="https://github.com/JagosMarek/easurance/assets/128280984/0fe8d0ef-4bb2-40f3-8c17-db021f20a2ee" width="300" 
 height="650" />
 <img src="https://github.com/JagosMarek/easurance/assets/128280984/386c9776-7431-4a56-8486-a86a14652a73" width="300" 
 height="650" />
</p>

